package com.example.controller;

import com.example.dto.ConsultDTO;
import com.example.dto.ConsultListExamDTO;
import com.example.model.Consult;
import com.example.model.Exam;
import com.example.service.IConsultService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/consults")
public class ConsultController {

    private final IConsultService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ConsultDTO>> findAll() throws Exception {
        List<ConsultDTO> list = service.findAll().stream().map(this::convertToDto).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultDTO> findById(@PathVariable Integer id) throws Exception {
        Consult obj = service.findById(id);

        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ConsultListExamDTO dto) throws Exception {
        Consult obj1 = convertToEntity(dto.getConsult());
        List<Exam> list = dto.getLstExam().stream().map(ex -> modelMapper.map(ex, Exam.class)).toList();

        Consult obj = service.saveTransactional(obj1, list);

        //Consult obj = service.save(modelMapper.map(dto, Consult.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConsult()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultDTO> update(@PathVariable Integer id, @RequestBody ConsultDTO dto) throws Exception {
        dto.setIdConsult(id);
        Consult obj = service.update(id, convertToEntity(dto));

        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<ConsultDTO> findByIdHateoas(@PathVariable Integer id) throws Exception {
        Consult obj = service.findById(id);

        EntityModel<ConsultDTO> resource = EntityModel.of(convertToDto(obj));

        WebMvcLinkBuilder link1 = linkTo(methodOn(ConsultController.class).findById(obj.getIdConsult()));
        WebMvcLinkBuilder link2 = linkTo(methodOn(ConsultController.class).findAll());

        resource.add(link1.withRel("consult-self-info"));
        resource.add(link2.withRel("consult-all-info"));

        return resource;
    }

    private Consult convertToEntity(ConsultDTO dto) {
        return modelMapper.map(dto, Consult.class);
    }

    private ConsultDTO convertToDto(Consult entity) {
        return modelMapper.map(entity, ConsultDTO.class);
    }

}

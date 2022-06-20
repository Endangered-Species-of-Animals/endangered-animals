package com.esoa.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esoa.demo.entity.Contact;
import com.esoa.demo.repository.ContactRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    @Transactional
    public void create(Contact dto) {
        /*
         * if (contactRepository.existsByNameAndDescription(dto.getUser(),
         * dto.getDescription()))
         * throw new IllegalArgumentException("Error!");
         */

        Contact contact = new Contact();
        contact.setTitle(dto.getTitle());
        contact.setUser(dto.getUser());
        contact.setDescription(dto.getDescription());
        contact.setDischargeDate(LocalDate.now());
        contact.setDeleted(false);

        contactRepository.save(contact);

    }


    @Transactional(readOnly = true)
    public Contact getById(Integer id) {
        return contactRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Transactional(readOnly = true)
    public void enableById(Integer id) {
        contactRepository.enableById(id);
    }

    @Transactional
    public void deleteById(Integer id) {
        contactRepository.deleteById(id);
    }

}

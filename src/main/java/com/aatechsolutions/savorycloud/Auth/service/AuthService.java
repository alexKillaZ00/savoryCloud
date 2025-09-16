package com.aatechsolutions.savorycloud.Auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aatechsolutions.savorycloud.Usuario.entity.Role;
import com.aatechsolutions.savorycloud.Usuario.repository.EmployeeRepository;
import com.aatechsolutions.savorycloud.Auth.dto.RegisterDTO;
import com.aatechsolutions.savorycloud.Usuario.entity.Employee;

@Service
public class AuthService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterDTO registerDTO) {

        Employee newEmployee = new Employee();
        newEmployee.setUsername(registerDTO.getUsername());
        newEmployee.setFullName(registerDTO.getFullName());
        newEmployee.setEmail(registerDTO.getEmail());
        newEmployee.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        newEmployee.setPhoneNumber(registerDTO.getPhoneNumber());
        newEmployee.setAddress(registerDTO.getAddress());
        newEmployee.setSalary(registerDTO.getSalary());
        newEmployee.setBirthDate(registerDTO.getBirthDate());
        newEmployee.setRole(Role.ADMIN); // Rol por defecto
        newEmployee.setEducationLevel(registerDTO.getEducationLevel());
        newEmployee.setDiscapacity(registerDTO.getDiscapacity());
        newEmployee.setMaritalStatus(registerDTO.getMaritalStatus());

        // Aquí iría la lógica para guardar el nuevo empleado en la base de datos
        employeeRepository.save(newEmployee);
    }

}

package com.aatechsolutions.savorycloud.Usuario.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username; //obligatorio
    
    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName; //obligatorio
    
    @Column(name = "password", nullable = false, length = 255)
    private String password; //obligatorio
    
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email; //obligatorio
    
    @Column(name = "phone_number", unique = true, nullable = false, length = 20)
    private String phoneNumber; //obligatorio
    
    @Column(name = "address", nullable = false, length = 500)
    private String address; //obligatorio
    
    @Column(name = "salary", nullable = false, precision = 10, scale = 2)
    private BigDecimal salary; //obligatorio
    
    @Column(name = "entry_time")
    private LocalDateTime entryTime = null;
    
    @Column(name = "exit_time")
    private LocalDateTime exitTime = null;
    
    @Column(name = "social_security_number", length = 30)
    private String socialSecurityNumber = null; 
    
    @Column(name = "debit_card_number", length = 20)
    private String debitCardNumber = null; 
    
    @Column(name = "bank_name", length = 100)
    private String bankName = null;
    
    @Column(name = "status", nullable = false)
    private boolean status = true; //activo/inactivo //obligatorio
    
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate; //obligatorio
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); //obligatorio
    
    @Column(name = "last_accessed")
    private LocalDateTime lastAccessed; //obligatorio
    
    @Column(name = "marital_status", length = 30)
    private String maritalStatus = null;
    
    @Column(name = "education_level", length = 50)
    private String educationLevel = null; 
    
    @Column(name = "disability", length = 200)
    private String discapacity = null; 
    
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 20)
    private Role role; //obligatorio //ADMIN, CAJERO, MESERO, COCINERO, REPARTIDOR Y LIMPIEZA
    
    // Constructor vacío requerido por JPA
    public Employee() {}
    
    // Constructor con campos obligatorios
    public Employee(String username, String fullName, String password, String email, 
                   String phoneNumber, String address, BigDecimal salary, boolean status, 
                   LocalDate birthDate, Role role) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
        this.status = status;
        this.birthDate = birthDate;
        this.role = role;
        this.createdAt = LocalDateTime.now();
        this.lastAccessed = LocalDateTime.now();
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getDebitCardNumber() {
        return debitCardNumber;
    }

    public void setDebitCardNumber(String debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(LocalDateTime lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getDiscapacity() {
        return discapacity;
    }

    public void setDiscapacity(String discapacity) {
        this.discapacity = discapacity;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}

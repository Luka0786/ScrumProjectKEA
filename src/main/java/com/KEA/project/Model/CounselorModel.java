package com.KEA.project.Model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "Counselor_Table")
public class CounselorModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counselor_id")
    @Nullable
    private long id;

    @Nullable
    @Column(name = "first_name")
    private String firstName;

    @Nullable
    @Column(name = "last_name")
    private String lastName;

    @Nullable
    @Column(name = "name")
    private String name;

    @Email
    @Nullable
    @Column(name = "email")
    private String email;
/*
    @Column(name = "students_map")
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "counselor")
    private Map<Long,StudentModel> studentsMap = new HashMap<>();
*/
private HashMap<Long,StudentModel> studentsMap;

//StudentModel model = new StudentModel("dasd","www.test@idiot.com","test","testword",1);

@Nullable
@Column(name = "students_map")
@OneToMany(fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        mappedBy = "counselor")
public HashMap<Long,StudentModel> getStudentsMap()
{
    return studentsMap;
}



    public CounselorModel()
    {

    }

    public CounselorModel(String firstName, String lastName, String name, @Email String email, HashMap<Long,StudentModel> studentsMap) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = name;
        this.email = email;
        this.studentsMap = studentsMap;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStudentsMap(HashMap<Long,StudentModel> studentsMap) {
        this.studentsMap = studentsMap;
    }
}

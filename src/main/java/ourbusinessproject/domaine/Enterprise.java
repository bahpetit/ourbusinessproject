package ourbusinessproject.domaine;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Enterprise {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 1)
    private String name;
    @NotNull @Size(min = 10)
    private String description;
    @NotNull @Size(min = 1)
    private String contactName;
    @Email
    @NotNull @Size(min = 1)
    private String contactEmail;
    @OneToMany(mappedBy = "enterprise")
    @JsonIgnore
    private Set<Project> projects;

    public Enterprise() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        if(this.projects == null){
            this.projects = new HashSet<Project>();
        }
        this.projects.add(project);
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactEmail='" + contactEmail + '\''+
                '}';
    }
}

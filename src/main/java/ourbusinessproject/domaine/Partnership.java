package ourbusinessproject.domaine;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
public class Partnership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private Date creationDate;
    @NotNull
    @ManyToOne
    private Enterprise enterprise;
    @NotNull
    @OneToOne
    private Project project;

    public Partnership(long l) {
        this.id = l;
    }

    public Partnership() {
        this.creationDate = new Date();
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public Project getProject() {
        return project;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}

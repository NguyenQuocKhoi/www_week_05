package vn.edu.iuh.fit.backEnd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.backEnd.enums.SkillType;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private long id;

    @Column(name = "skill_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private SkillType type;

    @Column(name = "skill_name", nullable = false, columnDefinition = "varchar(150)")
    private String skillName;

    @Column(name = "skill_desc", nullable = false, columnDefinition = "varchar(300)")
    private String skillDescription;

    @OneToMany(mappedBy = "skill")
    private List<JobSkill> jobSkills;


}

package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.SkillLevel;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "job_skill")
public class JobSkill implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name = "skill_level", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private SkillLevel skillLevel;

    @Column(name = "more_infos", nullable = false, columnDefinition = "varchar(100)")
    private String moreInfos;
    public JobSkill() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobSkill jobSkill)) return false;
        return Objects.equals(job, jobSkill.job) && Objects.equals(skill, jobSkill.skill) && skillLevel == jobSkill.skillLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, skill, skillLevel);
    }
}

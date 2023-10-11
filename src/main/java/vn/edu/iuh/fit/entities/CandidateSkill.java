package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.SkillLevel;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "candidate_skill")
public class CandidateSkill implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    @Id
    @OneToOne
    @JoinColumn(name="skill_id")
    private Skill skill;

    @Column(name = "skill_level", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private SkillLevel skillLevel;

    @Column(name = "more_infos", nullable = false, columnDefinition = "varchar(1000)")
    private String moreInfos;

    public CandidateSkill() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandidateSkill that)) return false;
        return Objects.equals(candidate, that.candidate) && Objects.equals(skill, that.skill) && skillLevel == that.skillLevel && Objects.equals(moreInfos, that.moreInfos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate, skill, skillLevel, moreInfos);
    }
}

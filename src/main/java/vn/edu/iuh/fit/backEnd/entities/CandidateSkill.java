package vn.edu.iuh.fit.backEnd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.backEnd.enums.SkillLevel;

import java.io.Serializable;
import java.util.Objects;
import vn.edu.iuh.fit.backEnd.ids.CandidateSkillID;

@Entity
@Table(name = "candidate_skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CandidateSkillID.class)
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

}

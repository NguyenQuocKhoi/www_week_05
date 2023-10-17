package vn.edu.iuh.fit.backEnd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.backEnd.enums.SkillLevel;

import java.io.Serializable;
import java.util.Objects;
import vn.edu.iuh.fit.backEnd.ids.JobSkillID;

@Entity
@Table(name = "job_skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(JobSkillID.class)
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

}

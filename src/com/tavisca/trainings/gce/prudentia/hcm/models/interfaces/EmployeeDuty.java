package com.tavisca.trainings.gce.prudentia.hcm.models.interfaces;

import com.tavisca.trainings.gce.prudentia.hcm.models.classes.Employee;
import com.tavisca.trainings.gce.prudentia.hcm.models.classes.Skill;
import com.tavisca.trainings.gce.prudentia.hcm.models.classes.SkillMatrix;

import java.util.Set;

public interface EmployeeDuty {
    int getId();

    String getName();

    String getDepartment();

    Set<SkillMatrix> getSkillsMatrix();

    Employee update();

    Employee viewProfileOfEmployee(int id);
}

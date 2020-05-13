package ru.job4j.others;

import java.util.Date;

public class Profession {
    private String name;
    private String surname;
    private Education education;
    private Date birthday;

    public Profession(String name, String surname, Education education, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Education getEducation() {
        return education;
    }

    public Date getBirthday() {
        return birthday;
    }

    public static class Doctor extends Profession {
        private String hospital;

        public Doctor(String name, String surname, Education education, Date birthday, String hospital) {
            super(name, surname, education, birthday);
            this.hospital = hospital;
        }

        public String getHospital() {
            return hospital;
        }

        public Pills prescribe(Diagnose diagnose) {
            return null;
        }

        public Diagnose heal(Patient patient) {
            return null;
        }
    }

    public static class Engineer extends Profession {
        private Project project;

        public Engineer(String name, String surname, Education education, Date birthday, Project project) {
            super(name, surname, education, birthday);
            this.project = project;
        }

        public Project getProject() {
            return project;
        }

        public Statistics getProjectData(Project project) {
            return null;
        }
    }

    public static class Surgeon extends Doctor {
        private int operationAmount;

        public Surgeon(String name, String surname, Education education, Date birthday, String hospital, int operationAmount) {
            super(name, surname, education, birthday, hospital);
            this.operationAmount = operationAmount;
        }

        public int getOperationAmount() {
            return operationAmount;
        }

        public Boolean isSurgerySuccessful(Patient patient, int operationAmount, Diagnose diagnose, int age) {
            return false;
        }
    }

    public static class Dentist extends Doctor {
        private int treatmentAmount;

        public Dentist(String name, String surname, Education education, Date birthday, String hospital, int treatmentAmount) {
            super(name, surname, education, birthday, hospital);
            this.treatmentAmount = treatmentAmount;
        }

        public int getTreatmentAmount() {
            return treatmentAmount;
        }

        public Boolean isTeethCured(Patient patient, int treatmentAmount, Diagnose diagnose, int age) {
            return false;
        }
    }

    public static class Programmer extends Engineer {
        private int skillsLevel;
        private String[] programmerSkills;

        public Programmer(String name, String surname, Education education, Date birthday, Project project, int skillsLevel, String[] programmerSkills) {
            super(name, surname, education, birthday, project);
            this.skillsLevel = skillsLevel;
            this.programmerSkills = programmerSkills;
        }

        public int getSkillsLevel() {
            return skillsLevel;
        }

        public String[] getProgrammerSkills() {
            return programmerSkills;
        }

        public boolean isItProjectSuccessful(Project project, int skillsLevel, String[] programmerSkills) {
            return false;
        }
    }

    public static class Builder extends Engineer {
        private int skillsLevel;
        private String[] builderSkills;

        public Builder(String name, String surname, Education education, Date birthday, Project project, int skillsLevel, String[] builderSkills) {
            super(name, surname, education, birthday, project);
            this.skillsLevel = skillsLevel;
            this.builderSkills = builderSkills;
        }

        public int getSkillsLevel() {
            return skillsLevel;
        }

        public String[] getBuilderSkills() {
            return builderSkills;
        }

        public boolean isConstructionSiteFinished(Project project, int skillsLevel, String[] builderSkills) {
            return false;
        }
    }

    public static void main(String[] args) {
        Builder builder = new Builder("Ivan", "Ivanov", Education.EDUCATION2, new Date(), new Project(), 10, new String[2]);
        System.out.println(builder.getName());
        Engineer engineer = new Engineer("Petr", "Petrov", Education.EDUCATION2, new Date(), new Project());
        System.out.println(engineer.getName());
    }
}


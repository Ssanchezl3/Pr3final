public class Empleado {
    private String primerNombre;
    private String apellidoPaterno;

    private int absentismo;
    private boolean extraCuricular;
    private int weeklySelfStudy;
    private int history_score;
    private int physics_score;
    private int chemistry_score;
    private int biology_score;
    private int english_score;
    private int geography_score;
    private boolean partTime;

    private String carrera;
    private String email;
    private String genero;
    private int math_grade;
    public Empleado(String primerNombre, String apellidoPaterno,int math_grade, String carrera, String email, String genero, boolean partTime, int absentismo, boolean extraCuricular, int weeklySelfStudy, int history_score, int physics_score, int chemistry_score,int biology_score,int english_score, int geography_score ) {
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.math_grade = math_grade;
        this.carrera = carrera;
        this.email = email;
        this.genero = genero;
        this.partTime = partTime;
        this.absentismo = absentismo;
        this.extraCuricular = extraCuricular;
        this.weeklySelfStudy = weeklySelfStudy;
        this.history_score = history_score;
        this.physics_score = physics_score;
        this.chemistry_score = chemistry_score;
        this.biology_score = biology_score;
        this.english_score = english_score;
        this.geography_score = geography_score;
        //class studnet pero lazy


    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }


    public int getAbsentismo() {
        return absentismo;
    }
    public int getWeeklySelfStudy() {
        return weeklySelfStudy;
    }
    public int getHistory_score() {
        return history_score;
    }
    public int getPhysics_score() {
        return physics_score;
    }
    public int getChemistry_score() {
        return chemistry_score;
    }
    public int getBiology_score() {
        return biology_score;
    }
    public int getEnglish_score() {
        return english_score;
    }
    public int getGeography_score() {
        return geography_score;
    }
    public boolean getExtraCuricular() {
        return extraCuricular;
    }
    public boolean getPartTime() {
        return partTime;
    }
    public String getCarrera() {
        return carrera;
    }
    public String getEmail() {
        return email;
    }
    public String getGenero() {
        return genero;
    }
    public int getMath_grade() {
        return math_grade;
    }
    public void setAbsentismo(int absentismo) {
        this.absentismo = absentismo;
    }
    public void setWeeklySelfStudy(int weeklySelfStudy) {
        this.weeklySelfStudy = weeklySelfStudy;
    }
    public void setHistory_score(int history_score) {
        this.history_score = history_score;
    }
    public void setPhysics_score(int physics_score) {
        this.physics_score = physics_score;
    }
    public void setChemistry_score(int chemistry_score) {
        this.chemistry_score = chemistry_score;
    }
    public void setBiology_score(int biology_score) {
        this.biology_score = biology_score;
    }
    public void setEnglish_score(int english_score) {
        this.english_score = english_score;
    }
    public void setGeography_score(int geography_score) {
        this.geography_score = geography_score;
    }
    public void setExtraCuricular(boolean extraCuricular) {
        this.extraCuricular = extraCuricular;
    }
    public void setPartTime(boolean partTime) {
        this.partTime = partTime;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setMath_grade(int math_grade) {
        this.math_grade = math_grade;
    }


    @Override
    public String toString() { //info for later
        return "Empleado{" +
                "primerNombre='" + primerNombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", genero=" + genero +
                ", partime_hours='" +  partTime+ '\'' +
                ", absentismo='" + absentismo + '\'' +
                ", extraCuricular='" + extraCuricular + '\'' +
                ", weeklySelfStudy='" + weeklySelfStudy + '\'' +
                ", history_score='" + history_score + '\'' +
                ", physics_score='" + physics_score + '\'' +
                ", chemistry_score='" + chemistry_score + '\'' +
                ", biology_score='" + biology_score + '\'' +
                ", english_score='" + english_score + '\'' +
                ", geography_score='" + geography_score + '\'' +
                ", math_grade='" + math_grade + '\'' +
                ", carrera='" + carrera + '\'' +
                ", email='" + email + '\'' +

                '}';
    }

    public int getmath_grade() {
        return math_grade;
    }

    public String getDepartamento() {
        return carrera;
    }
}


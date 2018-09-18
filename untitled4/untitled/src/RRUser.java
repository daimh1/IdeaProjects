public class RRUser {

    String account;
    String password;
    String realname;
    String sex;
    String year;
    String month;
    String day;
    String state;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RRUser{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", sex='" + sex + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public RRUser(String account, String password, String realname, String sex, String year, String month, String day, String state) {
        this.account = account;
        this.password = password;
        this.realname = realname;
        this.sex = sex;
        this.year = year;
        this.month = month;
        this.day = day;
        this.state = state;
    }
    public RRUser(){

    }
}

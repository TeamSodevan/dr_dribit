package in.sodevan.dr_dribit;

/**
 * Created by kartiksharma on 11/02/17.
 */

public class Item {

        private String name;
        private String age;
        private String heartbeat;
        private String gender;


        public Item(){

        }

        public Item(String Name, String Age, String Heartbeat,String Gender){
            this.name=Name;
            this.age=Age;
            this.heartbeat=Heartbeat;
            this.gender=Gender;

        }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getage() {
        return age;
    }

    public void setage(String age) {
        this.age = age;
    }
    public String getheartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(String heartbeat) {
        this.heartbeat = heartbeat;
    }
    public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }


    }


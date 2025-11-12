public class Seller {
    public int id;
    public String name;
    public String phone;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Seller(int id, String name) {
            setId(id);
            setName(name);
        }
    public Seller(int id, String name, String phone) {
        setId(id);
        setName(name);
        setPhone(phone);
    }

}

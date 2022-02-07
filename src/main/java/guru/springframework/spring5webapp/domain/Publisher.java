package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.sql.Array;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String addrLine1;
    private String city;
    private String state;
    private Integer zip;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();


    public Publisher() {
    }

    public Publisher(String name, String addrLine1, String city, String state, Integer zip) {
        this.id = id;
        this.name = name;
        this.addrLine1 = addrLine1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Returns a list of Address items in the following order:
    // [0]: addr line 1, [1]:, [2]: city, [3]: state, [4]: zip
    public ArrayList getAddr() {
        ArrayList addrList = new ArrayList(
                Arrays.asList(this.addrLine1, this.city, this.state, this.zip));
        return addrList;
    }

    public void setAddr(String addr, String ct, String st, Integer z) {
        this.addrLine1 = addr;
        this.city = ct;
        this.state = st;
        this.zip = z;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addrLine1='" + addrLine1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

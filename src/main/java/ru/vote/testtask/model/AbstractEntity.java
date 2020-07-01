package ru.vote.testtask.model;

public abstract class AbstractEntity {

    public static final int START_SEQ = 100000;

    protected Integer id;

    protected String name;

    public AbstractEntity() {
    }

    public AbstractEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractEntity that = (AbstractEntity) o;
        return getId().equals(that.getId()) &&
                getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }
}

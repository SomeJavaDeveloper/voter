package ru.vote.testtask.model;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractEntity{

    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "name", nullable = false)
    protected String name;

    public AbstractEntity() {
    }

    public AbstractEntity(String name) {
        this.name = name;
    }

    // doesn't work for hibernate lazy proxy

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractEntity that = (AbstractEntity) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return name == null ? 0 : Integer.parseInt(name);
    }
}

package API.Vhost;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Directive {

    private  String name;
    private  String value;


    public Directive() {
    }

    public Directive(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Directive directive = (Directive) o;

        if (name != null ? !name.equals(directive.name) : directive.name != null) return false;
        return value != null ? value.equals(directive.value) : directive.value == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }


    public static List<Directive> getDirectiveExample(){
        List<Directive> directives = new ArrayList<>();
        directives.add(new Directive("AcceptFilter", "96579"));
        directives.add(new Directive("AddDescription", "12134"));

        return directives;
    }



}

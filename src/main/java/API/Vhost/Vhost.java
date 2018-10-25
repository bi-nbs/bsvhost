package API.Vhost;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vhost {

    private int id;
    private int port;
    private String serverName;
    private String serverAlias;
    private List<Directive> directives;

    public Vhost() {
    }

    public Vhost(int id ,int port, String serverName, String serverAlias, List<Directive> directives) {
        this.id = id;
        this.port = port;
        this.serverName = serverName;
        this.serverAlias = serverAlias;
        this.directives = directives;

    }

    private List<Directive> validateDirectives(List<Directive> directives){
        List<Directive> validatedDirectives = new ArrayList<>();

        return validatedDirectives;
    }

    public int getId() {
        return id;
    }

    public int getPort() {
        return port;
    }

    public String getServerName() {
        return serverName;
    }

    public String getServerAlias() {
        return serverAlias;
    }

    public List<Directive> getDirectives() {
        return directives;
    }


    @Override
    public String toString() {
        return "Vhost{" +
                "id=" + id +
                ", port=" + port +
                ", serverName='" + serverName + '\'' +
                ", serverAlias='" + serverAlias + '\'' +
                ", directives=" + directives +
                '}';
    }
}

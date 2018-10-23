package API.Backend;

import API.Vhost.Vhost;

import java.util.List;

public interface Backend {

    public List<Vhost> getAllVhosts();

    public Vhost getVhostById(int id);

    public void addVhost(Vhost vhost);

}

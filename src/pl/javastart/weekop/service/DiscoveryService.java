package pl.javastart.weekop.service;

import pl.javastart.weekop.dao.DAOFactory;
import pl.javastart.weekop.dao.DiscoveryDAO;
import pl.javastart.weekop.model.Discovery;
import pl.javastart.weekop.model.User;

import java.sql.Timestamp;
import java.util.Date;

public class DiscoveryService {
    public void addDiscovery(String name, String desc, String url, User user){
        Discovery discovery = createDiscoveryObject(name,desc,url,user);
        DAOFactory factory = DAOFactory.getDAOFactory();
        DiscoveryDAO discoveryDAO = factory.getDiscoveryDAO();
        discoveryDAO.create(discovery);
    }

    private Discovery createDiscoveryObject(String name, String desc, String url, User user) {
        Discovery discovery = new Discovery();
        discovery.setName(name);
        discovery.setDescription(desc);
        discovery.setUrl(url);
        User userCopy = new User(user);
        discovery.setUser(userCopy);
        discovery.setTimestamp(new Timestamp(new Date().getTime()));
        return discovery;
    }
}

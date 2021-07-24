package web.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import web.model.Role;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{

    private LocalSessionFactoryBean sessionFactoryBean;
    private Session session;

    @Autowired
    public void setSessionFactoryBean(LocalSessionFactoryBean sessionFactoryBean) {
        this.sessionFactoryBean = sessionFactoryBean;
    }

    @Override
    public List<Role> getRolesList() {
        session = sessionFactoryBean.getObject().getCurrentSession();
        return session.createQuery("from Role").getResultList();
    }

    @Override
    public Role getRoleById(int id) {
        session = sessionFactoryBean.getObject().getCurrentSession();
        return session.find(Role.class, id);
    }
}

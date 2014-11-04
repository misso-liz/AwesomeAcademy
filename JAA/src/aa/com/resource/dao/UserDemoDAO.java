package aa.com.resource.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import aa.com.resource.model.UserDemo;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserDemo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see aa.com.resource.model.UserDemo
 * @author MyEclipse Persistence Tools
 */
public class UserDemoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UserDemoDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String CARDID = "cardid";

	protected void initDao() {
		// do nothing
	}

	public void save(UserDemo transientInstance) {
		log.debug("saving UserDemo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserDemo persistentInstance) {
		log.debug("deleting UserDemo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserDemo findById(java.math.BigDecimal id) {
		log.debug("getting UserDemo instance with id: " + id);
		try {
			UserDemo instance = (UserDemo) getHibernateTemplate().get(
					"aa.com.resource.model.UserDemo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserDemo instance) {
		log.debug("finding UserDemo instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding UserDemo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserDemo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByCardid(Object cardid) {
		return findByProperty(CARDID, cardid);
	}

	public List findAll() {
		log.debug("finding all UserDemo instances");
		try {
			String queryString = "from UserDemo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserDemo merge(UserDemo detachedInstance) {
		log.debug("merging UserDemo instance");
		try {
			UserDemo result = (UserDemo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserDemo instance) {
		log.debug("attaching dirty UserDemo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserDemo instance) {
		log.debug("attaching clean UserDemo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserDemoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserDemoDAO) ctx.getBean("UserDemoDAO");
	}
}
package com.linkbox.linkbox.services;

import com.linkbox.linkbox.models.Message;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkbox.linkbox.dao.LinkDao;
import com.linkbox.linkbox.models.Link;

@Service
public class LinkService {
    Logger logger = Logger.getLogger("Link logger");
    
    @Autowired
    LinkDao linkDao;

    public Message createLink(Link link) {
        try {
            link.setViews(0);
            link.setInTheTrash("N");
            link.setCreatedAt(LocalDateTime.now());
            link.setModifiedAt(LocalDateTime.now());
            linkDao.save(link);
            return new Message("link added");
        } catch(Exception e) {
            logger.error(e.getMessage());
            return new Message("link not added: "+e.getLocalizedMessage());
        }
    }

    public Message deleteLink(Integer id) {
        try {
            linkDao.deleteById(id);;
            return new Message("link deleted.");
        } catch(Exception e) {
            logger.error(e.getMessage());
            return new Message("link not deleted: "+e.getLocalizedMessage());
        }
    }

    public boolean updateLink(Integer id, Link newData) {
        newData.setUserId(id);
        try {
            linkDao.saveAndFlush(newData);
            return true;
        } catch(Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public Optional<Link> getLink(Integer id) {
        return linkDao.findById(id);
    }

    public List<Link> getLinks() {
        return linkDao.findAll();
    }
}

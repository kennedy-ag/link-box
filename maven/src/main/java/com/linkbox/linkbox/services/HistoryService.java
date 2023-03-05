package com.linkbox.linkbox.services;

import com.linkbox.linkbox.models.HstLink;
import com.linkbox.linkbox.models.HstUser;
import com.linkbox.linkbox.models.Message;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkbox.linkbox.dao.HstLinkDao;
import com.linkbox.linkbox.dao.HstUserDao;

@Service
public class HistoryService {
    Logger logger = Logger.getLogger("History logger");
    
    @Autowired
    HstUserDao historyUserDao;

    @Autowired
    HstLinkDao historyLinkDao;

    public Message history(HstUser historyUser) {
        historyUserDao.save(historyUser);
        return new Message("user history saved");
    }

    public Message history(HstLink historyLink) {
        historyLinkDao.save(historyLink);
        return new Message("link history saved");
    }

}

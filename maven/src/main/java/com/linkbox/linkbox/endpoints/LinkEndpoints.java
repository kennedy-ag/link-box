package com.linkbox.linkbox.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.linkbox.linkbox.models.Message;
import com.linkbox.linkbox.models.HstLink;
import com.linkbox.linkbox.models.Link;
import com.linkbox.linkbox.services.HistoryService;
import com.linkbox.linkbox.services.LinkService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class LinkEndpoints {

    @Autowired
    LinkService linkService;

    @Autowired
    HistoryService historyService;
    
    @Operation(summary = "Create a link")
    @RequestMapping(path = "/links", method = RequestMethod.POST)
    public ResponseEntity<Message> createLink(@RequestBody Link link){
        Message msg = linkService.createLink(link);
        HstLink hstLink = new HstLink(link.getLinkId(), "I", "Link criado");
        historyService.history(hstLink);
        return new ResponseEntity<Message>(msg, HttpStatus.CREATED);
    }

    @Operation(summary = "Delete a link")
    @RequestMapping(path = "/links/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Message> deleteUser(@PathVariable Integer id){
        Message msg = linkService.deleteLink(id);
        HstLink hstLink = new HstLink(id, "E", "Link excluído");
        historyService.history(hstLink);
        return new ResponseEntity<Message>(msg, HttpStatus.OK);
    }
    
    @Operation(summary = "Lists all links")
    @RequestMapping(path = "/links", method = RequestMethod.GET)
    public ResponseEntity<List<Link>> getLinks(){
        List<Link> links = linkService.getLinks();
        return new ResponseEntity<List<Link>>(links, HttpStatus.OK);
    }
    
    @Operation(summary = "Get link by id")
    @RequestMapping(path = "/links/{id}", method = RequestMethod.GET)
    public ResponseEntity<Link> getLink(@PathVariable Integer id){
        return linkService.getLink(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update a link")
    @RequestMapping(path = "/links/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Message> updateLink(@PathVariable Integer id, @RequestBody Link newData){
        boolean updateSuccess = linkService.updateLink(id, newData);
        if(updateSuccess){
            return new ResponseEntity<Message>(new Message("link updated"), HttpStatus.OK);
        } else {
            return new ResponseEntity<Message>(new Message("link not updated"), HttpStatus.BAD_REQUEST);
        }
    }
}

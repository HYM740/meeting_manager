package me.hym.meeting.controller;

import me.hym.meeting.entity.Participants;
import me.hym.meeting.service.ParticipantsManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/manager/participants")
public class ParticipantsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        Participants p = new Participants();
        p.setEid(Integer.parseInt(req.getParameter("eid")));
        p.setMid(Integer.parseInt(req.getParameter("mid")));
        ParticipantsManager.createParticipants(p);
        resp.sendRedirect(req.getContextPath()+"/manager/meet?eid="+p.getEid());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

package me.hym.meeting.controller;

import me.hym.meeting.entity.MeetingRoom;
import me.hym.meeting.service.MeetingRoomManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manager/room")
public class RoomController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        List<MeetingRoom> meetingRoomList= MeetingRoomManager.getAllMeetingRoom();
        req.setAttribute("meetingRoom_list",meetingRoomList);
        req.getRequestDispatcher("/manager/room/room.jsp").forward(req,resp);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPut(req, resp);
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doDelete(req, resp);
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}

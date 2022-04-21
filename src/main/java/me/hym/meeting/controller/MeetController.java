package me.hym.meeting.controller;

import me.hym.meeting.entity.Meet;
import me.hym.meeting.entity.Participants;
import me.hym.meeting.service.MeetManager;
import me.hym.meeting.service.ParticipantsManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/manager/meet")
public class MeetController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.setCharacterEncoding("UTF-8");
        String para = req.getParameter("eid");
        List<Meet> meetList = MeetManager.getAllMeet();
        //去除非相关的会议
        if(para!=null){
            int eid = Integer.parseInt(para);
            List<Participants> participants =ParticipantsManager.getAllParticipants();
            participants.removeIf(p -> p.getEid()!= eid);
            List<Meet> mymeetList = new ArrayList<>();
            for(Participants p : participants){
                if(p.getEid()==eid){
                    mymeetList.add(MeetManager.getMeet(p.getMid()));
                }
            }
            meetList=mymeetList;
        }
        req.setAttribute("meetList",meetList);
        //避免递归
        String method = (String) req.getAttribute("other");
        if (method != null && method.equals("0")) {
            req.getRequestDispatcher("/manager/meet/meet.jsp").forward(req, resp);
            return;
        }
//        删除操作
        String delete = req.getParameter("method");
        if(delete!=null&&delete.equals("delete")){
            String mid = req.getParameter("mid");

            if (mid == null) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            Meet m = MeetManager.getMeet(Integer.parseInt(mid));
            m.setMstate(2);
            boolean result = MeetManager.updateMeet(m);
            if(result){
                req.getRequestDispatcher("/manager/meet/meet.jsp").forward(req,resp);
            }else{
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
            return;
        }
        String mid = req.getParameter("mid");
        if(mid!=null){
            req.getRequestDispatcher("/manager/meet/updateMeet.jsp").forward(req,resp);
            return;
        }

        req.getRequestDispatcher("/manager/meet/meet.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method=req.getParameter("method");
        boolean result = false;
        Meet m = null;
        if(method == null){
            int mid = Integer.parseInt(req.getParameter("mid"));
            m = MeetManager.getMeet(mid);
        }else if(method.equals("put")){
            m = new Meet();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            String ms = req.getParameter("msdate").replace('T',' ');
            String me = req.getParameter("medate").replace('T',' ');
            m.setMsdate(sdf.parse(ms));
            m.setMedate(sdf.parse(me));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        m.setEid(Integer.parseInt(req.getParameter("eid")));
        m.setRid(Integer.parseInt(req.getParameter("rid")));
        m.setMtitle(req.getParameter("mtitle"));
        if(method==null){
            result = MeetManager.updateMeet(m);
        }else if (method.equals("put")){
            result = MeetManager.createMeet(m);
            List<Meet> meets = MeetManager.getAllMeet();
            m=meets.get(meets.size()-1);
        }
        if (result) {
            Participants p = new Participants();
            p.setEid(m.getEid());
            p.setMid(m.getMid());
            ParticipantsManager.createParticipants(p);
            req.setAttribute("other", "0");
            doGet(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}

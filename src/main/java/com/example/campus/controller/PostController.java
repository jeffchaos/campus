package com.example.campus.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.campus.entity.Post;
import com.example.campus.entity.Result;
import com.example.campus.service.CommentService;
import com.example.campus.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;
    @RequestMapping(value = "getAllPosts",method = RequestMethod.GET)
    public Map<String,List<Post>> getAllPosts(){
        Map<String,List<Post>> map = new HashMap<>();
        String msg = "";
        List<Post> posts = postService.selectAllPosts();
        if(posts != null)
            msg = "success";
        map.put(msg,posts);
        return map;
    }


//    @RequestMapping(value = "publish",method = RequestMethod.POST)
//    public int publishPost(HttpServletRequest request, HttpServletResponse response){
//
//    }
//    @RequestMapping(value = "upload")
//    public String upload(/*@RequestParam(value = "file_upload")*/ MultipartFile multipartFile, HttpServletRequest request, Model model, MultipartRequest multipartRequest){
////        if (multipartFile.isEmpty()) {
////            System.out.`intln("文件为空空");
////        }
//
//        Enumeration params = request.getParameterNames();
//        while (params.hasMoreElements()){
//            String name = (String) params.nextElement();
//            String value = request.getParameter(name);
//            System.out.println(name+":"+value);
//        }
//
//        System.out.println("文件开始上传");
//        String fileName = multipartFile.getOriginalFilename();  // 文件名
//        System.out.println(fileName);
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
//        //上传到服务器之中了
////        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
//        String filePath = "E://imgsForCampusApp/";
//
//        File dest = new File(filePath + fileName);
//        if (!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdirs(); }
//        try { multipartFile.transferTo(dest);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String filename = "/temp-rainy/" + fileName;
//        model.addAttribute("filename", filename);
//        return "ok";
//    }

    @GetMapping("getPostByType")
    public String getPostByType(String type){
        Map<String ,Object> map=new HashMap<>();
        map.put("data",postService.getPostByType(type));
        map.put("api","getPostByType");
        return JSONObject.toJSONString(new Result(map,"200","获取帖子详情成功"));
    }

    @GetMapping("getPostById")
    public String getPostById(String id){
        Map<String ,Object> map=new HashMap<>();
        map.put("data",commentService.selCommentByPostId(Integer.parseInt(id)));
        map.put("api","getPostById");
        return JSONObject.toJSONString(new Result(map,"200","获取帖子评论成功"));
    }

}

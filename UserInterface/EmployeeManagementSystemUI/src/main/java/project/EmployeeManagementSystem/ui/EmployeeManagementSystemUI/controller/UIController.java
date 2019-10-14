package project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.entity.ProjectWithTask;

import project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.config.AccessToken;
import project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.entity.Employee;
import project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.entity.Project;

import project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@EnableOAuth2Sso
public class UIController extends WebSecurityConfigurerAdapter {
    @Autowired
    RestTemplate restTemplate;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();
    }
    @RequestMapping(value = "/")
    public String loadHome(){
        return "home";
    }
    @RequestMapping(value = "/lg")
    public String loadMainPage(){
        return "mainPage";
    }
    @RequestMapping(value = "/create-employee")
    public String loadCreateEmployee(){
        return "addEmployee";
    }

    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    public String loadEmployee(Model model){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<Employee> employeeHttpEntity=new HttpEntity<>(httpHeaders);
        try {
            ResponseEntity<Employee[]> responseEntity=restTemplate.exchange("http://localhost:8082/employees", HttpMethod.GET,employeeHttpEntity,Employee[].class);
            model.addAttribute("employees",responseEntity.getBody());
        }
        catch (HttpStatusCodeException e){
            ResponseEntity responseEntity=ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error",responseEntity);
        }



        return "employee";
    }
    @RequestMapping(value = "/employees/{id}",method = RequestMethod.GET)
    public String loadEmployees(Model model, @PathVariable Integer id){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<Employee> employeeHttpEntity=new HttpEntity<>(httpHeaders);
        try {
            ResponseEntity<Employee> responseEntity=restTemplate.exchange("http://localhost:8082/employees/"+id, HttpMethod.GET,employeeHttpEntity,Employee.class);
            model.addAttribute("employee",responseEntity.getBody());
        }
        catch (HttpStatusCodeException e){
            ResponseEntity responseEntity=ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error",responseEntity);
        }



        return "employeeData";
    }
    @RequestMapping(value = "/employees",method = RequestMethod.POST)
    public String save(@ModelAttribute Employee employee,Model model){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<Employee> employeeHttpEntity=new HttpEntity<>(employee,httpHeaders);
        System.out.println(employee);
        try {
            ResponseEntity<Employee> responseEntity=restTemplate.exchange("http://localhost:8082/employees", HttpMethod.POST,employeeHttpEntity,Employee.class);

        }
        catch (HttpStatusCodeException e){
            ResponseEntity responseEntity=ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error",responseEntity);
        }
        return "redirect:employees";

    }
    @RequestMapping(value = "/create-project")
    public String loadCreateProject(){
        return "addProject";
    }

    @RequestMapping(value = "/projects",method = RequestMethod.GET)
    public String loadProject(Model model){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<Project> projectHttpEntity=new HttpEntity<>(httpHeaders);
        try {
            ResponseEntity<Project[]> responseEntity=restTemplate.exchange("http://localhost:8084/projects", HttpMethod.GET,projectHttpEntity,Project[].class);
            model.addAttribute("projects",responseEntity.getBody());
        }
        catch (HttpStatusCodeException e){
            ResponseEntity responseEntity=ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error",responseEntity);
        }



        return "project";
    }
    @RequestMapping(value = "/projects/{id}",method = RequestMethod.GET)
    public String loadProject(Model model, @PathVariable Integer id){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<Project> projectHttpEntity=new HttpEntity<>(httpHeaders);
        try {
            ResponseEntity<Project> responseEntity=restTemplate.exchange("http://localhost:8084/projects/"+id, HttpMethod.GET,projectHttpEntity,Project.class);
            model.addAttribute("project",responseEntity.getBody());
        }
        catch (HttpStatusCodeException e){
            ResponseEntity responseEntity=ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error",responseEntity);
        }



        return "projectData";
    }
    @RequestMapping(value = "/projects",method = RequestMethod.POST)
    public String save(@ModelAttribute Project project,Model model){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<Project> projectHttpEntity=new HttpEntity<>(project,httpHeaders);

        try {
            ResponseEntity<Project> responseEntity=restTemplate.exchange("http://localhost:8084/projects", HttpMethod.POST,projectHttpEntity,Project.class);

        }
        catch (HttpStatusCodeException e){
            ResponseEntity responseEntity=ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error",responseEntity);
        }
        return "redirect:projects";

    }
    @RequestMapping(value = "/create-task")
    public String loadCreateTask(){
        return "addTask";
    }

    @RequestMapping(value = "/tasks",method = RequestMethod.GET)
    public String loadTask(Model model){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<Task> taskHttpEntity=new HttpEntity<>(httpHeaders);
        try {
            ResponseEntity<Task[]> responseEntity=restTemplate.exchange("http://localhost:8083/tasks", HttpMethod.GET,taskHttpEntity,Task[].class);
            model.addAttribute("tasks",responseEntity.getBody());
        }
        catch (HttpStatusCodeException e){
            ResponseEntity responseEntity=ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error",responseEntity);
        }



        return "task";
    }
    @RequestMapping(value = "/tasks/{id}",method = RequestMethod.GET)
    public String loadTasks(Model model, @PathVariable Integer id){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<Task> taskHttpEntity=new HttpEntity<>(httpHeaders);
        try {
            ResponseEntity<Task> responseEntity=restTemplate.exchange("http://localhost:8083/tasks/"+id, HttpMethod.GET,taskHttpEntity,Task.class);
            model.addAttribute("task",responseEntity.getBody());
        }
        catch (HttpStatusCodeException e){
            ResponseEntity responseEntity=ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error",responseEntity);
        }



        return "taskData";
    }
    @RequestMapping(value = "/tasks",method = RequestMethod.POST)
    public String save(@ModelAttribute Task task,Model model) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<Task> taskHttpEntity = new HttpEntity<>(task, httpHeaders);

        try {
            ResponseEntity<Task> responseEntity = restTemplate.exchange("http://localhost:8083/tasks", HttpMethod.POST, taskHttpEntity, Task.class);

        } catch (HttpStatusCodeException e) {
            ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error", responseEntity);
        }
        return "redirect:tasks";


    }
    @RequestMapping(value = "/projectwithtasks",method = RequestMethod.GET)
    public String loadCreateProjectWithTask(Model model){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<Project> projectHttpEntity=new HttpEntity<>(httpHeaders);
        ResponseEntity<Project[]> responseEntity=restTemplate.exchange("http://localhost:8084/projects/", HttpMethod.GET,projectHttpEntity,Project[].class);
        model.addAttribute("projects",responseEntity.getBody());


        HttpEntity<Task> taskHttpEntity=new HttpEntity<>(httpHeaders);
        ResponseEntity<Task[]> responseEntity01=restTemplate.exchange("http://localhost:8083/tasks", HttpMethod.GET,taskHttpEntity,Task[].class);
        model.addAttribute("tasks",responseEntity01.getBody());

        HttpEntity<Employee> employeeHttpEntity=new HttpEntity<>(httpHeaders);
        ResponseEntity<Employee[]> responseEntity02=restTemplate.exchange("http://localhost:8082/employees", HttpMethod.GET,taskHttpEntity,Employee[].class);
        model.addAttribute("employees",responseEntity02.getBody());



        return "addProjectWithTask";
    }
    @RequestMapping(value = "/projectwithtask",method = RequestMethod.POST)
    public String saveProjectWithTask(@RequestParam("taskName") List<String> tasks,@RequestParam("projectId") String project,@RequestParam("employeeId") Integer employeeId,Model model) {
        HttpHeaders httpHeaders = new HttpHeaders();
        System.out.println(AccessToken.getAccessToken());
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        List<ProjectWithTask> projectWithTask = new ArrayList<>();


        for (String task: tasks
             ) {
            //System.out.println(tid+" "+projectId);
            projectWithTask.add(new ProjectWithTask(employeeId,Integer.parseInt(project.split("%@%")[1]),Integer.parseInt(task.split("%@%")[1]),project.split("%@%")[0],task.split("%@%")[0]));
            //System.out.println(project.getTaskId());




        }


       /*for(Integer tid:taskId){
         projectWithTask.add(new ProjectWithTask(projectId,tid));
       }
        System.out.println(projectWithTask);*/
       HttpEntity<List<ProjectWithTask>> projectWithTaskHttpEntity = new HttpEntity<>(projectWithTask, httpHeaders);


       ResponseEntity<List> responseEntity = restTemplate.exchange("http://localhost:8085/projectwithtasks", HttpMethod.POST, projectWithTaskHttpEntity, List.class);


        return "redirect:lg";}

    @RequestMapping(value = "/projectwithtask/{id}",method = RequestMethod.GET)
    public String loadEmployeeProjectById(Model model, @PathVariable Integer id){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<String> integerHttpEntity=new HttpEntity<>(httpHeaders);
        try {
            ResponseEntity<List<String>> responseEntity=restTemplate.exchange("http://localhost:8085/projectwithtasks/"+id, HttpMethod.GET, integerHttpEntity, new ParameterizedTypeReference<List<String>>() {});

            List<String> names=new ArrayList<>();

            names=responseEntity.getBody();
            model.addAttribute("employeeId",id);
            names=names.stream().distinct().collect(Collectors.toList());
            model.addAttribute("projectName",names);
        }
        catch (HttpStatusCodeException e){
            ResponseEntity responseEntity=ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error",responseEntity);
        }




        return "projectwithtask-project";
    }
    @RequestMapping(value = "/projectwithtaskwithemployee/{id}/{id1}",method = RequestMethod.GET)
    public String loadEmployeeProjectTaskById(Model model, @PathVariable Integer id,@PathVariable String id1){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());



        HttpEntity<String> integerHttpEntity=new HttpEntity<>(httpHeaders);
        try {
            ResponseEntity<List<String>> responseEntity=restTemplate.exchange("http://localhost:8085/projectwithtaskwithemployee/"+id+"/"+id1, HttpMethod.GET, integerHttpEntity, new ParameterizedTypeReference<List<String>>() {});

            List<String> tasks=new ArrayList<>();

            tasks=responseEntity.getBody();
            System.out.println(tasks);


            model.addAttribute("taskName",tasks);
        }
        catch (HttpStatusCodeException e){
            ResponseEntity responseEntity=ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error",responseEntity);
        }




        return "projectwithtask-task";
    }
}

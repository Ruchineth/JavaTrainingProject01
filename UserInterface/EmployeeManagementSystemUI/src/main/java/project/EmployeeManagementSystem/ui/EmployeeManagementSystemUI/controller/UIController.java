package project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
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
import project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.config.AccessToken;
import project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.entity.Employee;
import project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.entity.Project;
import project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.entity.Task;

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
        System.out.println(project);
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
        System.out.println(task);
        try {
            ResponseEntity<Task> responseEntity = restTemplate.exchange("http://localhost:8083/tasks", HttpMethod.POST, taskHttpEntity, Task.class);

        } catch (HttpStatusCodeException e) {
            ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error", responseEntity);
        }
        return "redirect:tasks";


    }}

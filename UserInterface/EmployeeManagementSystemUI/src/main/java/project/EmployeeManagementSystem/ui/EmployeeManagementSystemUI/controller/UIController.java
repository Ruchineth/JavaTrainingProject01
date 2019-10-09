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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.config.AccessToken;
import project.EmployeeManagementSystem.ui.EmployeeManagementSystemUI.entity.Employee;

@Controller
@EnableOAuth2Sso
public class UIController extends WebSecurityConfigurerAdapter {
    @Autowired
    RestTemplate restTemplate;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();
    }

    @RequestMapping(value = "/employees")
    public String loadEmployees(Model model){
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



        return "home";
    }
}

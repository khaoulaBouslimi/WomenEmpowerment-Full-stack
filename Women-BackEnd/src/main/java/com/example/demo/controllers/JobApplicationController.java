package com.example.demo.controllers;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.JobApplication;
import com.example.demo.services.JobApplicationService;

@RestController
@RequestMapping("/api/jobapplication")
public class JobApplicationController implements ServletContextAware {
//public class JobApplicationController{
	//uplodwnload
	//@Autowired
	 //private DatabaseFileService fileStorageService;
	
	private ServletContext servletContext;
	@Autowired
	JobApplicationService jobAppliServ;
	
	// Save operation
    @PostMapping("/jobAppli")
 
    public JobApplication addJobApplication( @Valid @RequestBody JobApplication jobAppli)
    {
        return jobAppliServ.addJobApplication(jobAppli);
    }
    
 // Read operation
    @GetMapping("/jobAppli")
    
    public List<JobApplication> fetchJobApplicationList()
    {
        return jobAppliServ.fetchJobApplicationList();
    }
    

 // Update operation
    @PutMapping("/jobAppli/{idApplication}")
 
    public JobApplication updateJobApplication(@RequestBody JobApplication jobAppli, @PathVariable("idApplication") Long idApplication)
    {
        return jobAppliServ.updateJobApplication(	jobAppli, idApplication);
    }
    
 // Delete operation
    @DeleteMapping("/jobAppli/{idApplication}")
 
    public String deleteJobApplicationById(@PathVariable("idApplication")  Long idApplication)
    {
    	jobAppliServ.deleteJobApplicationById(	idApplication);
        return "Deleted Successfully";
    }
    //upload multifiles done
   @RequestMapping(value="upload", method = RequestMethod.POST)
    public ResponseEntity<Void> upload(@RequestParam("files") MultipartFile[]files){
    	try {
    		System.out.println("file list");
    		for (MultipartFile file : files){
    			System.out.println("file name:" + file.getOriginalFilename());
    			System.out.println("file size:" + file.getSize());
    			System.out.println("file type:" + file.getContentType());
    			//System.out.println("---------------");
    			//save(file);
    		}
    		return new ResponseEntity<Void>(HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);	
    }
    private String save(MultipartFile file){
    	try {
    		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dddmmmyyyy");
    		String newFileName = simpleDateFormat.format(new Date()) + file.getOriginalFilename();
    		byte[] bytes = file.getBytes();
    	Path path = (Path) Paths.get(this.servletContext.getRealPath("/uploads/images/" +newFileName));
    	//Files.write(path, bytes);
    	return newFileName;
    	} catch (Exception e){
    		
    	}
		return null;
    	
    	//return null;
    }

	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		this.servletContext = servletContext;
	}
    //*************************************************
   /* //uploadfiles
    @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
        DatabaseFile fileName = jobAppliServ.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/downloadFile/")
            .path(fileName.getFileName())
            .toUriString();

        return new Response(fileName.getFileName());
    }

  @PostMapping("/uploadMultipleFiles")
    public List < Response > uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
            .stream()
            .map(file -> uploadFile(file))
            .collect(Collectors.toList());
 
   }
	
	//download files
  @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity < Resource > downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        DatabaseFile databaseFile = fileStorageService.getFile(fileName);
		//return null;
		return ResponseEntity.ok()
	           .contentType(databaseFile.getFileType()))
	           .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
	           .body(new ByteArrayResource(databaseFile.getData()));
    }*/
	//************************************
	
}

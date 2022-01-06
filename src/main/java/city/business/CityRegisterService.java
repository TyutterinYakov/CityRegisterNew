package city.business;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import city.dao.AddressRepository;
import city.dao.BirthRepository;
import city.dao.PassportRepository;
import city.dao.PersonRepository;
import city.dao.StreetRepository;
import city.domain.Address;
import city.domain.Birth;
import city.domain.Passport;
import city.domain.Person;
import city.domain.Street;
import city.view.PersonRequest;
import city.view.PersonResponse;

@Service
public class CityRegisterService {
	
	private static final Logger log = LoggerFactory.getLogger(CityRegisterService.class);
	@Autowired
	private AddressRepository addressDao;
	@Autowired
	private BirthRepository birthDao;
	@Autowired
	private PassportRepository passportDao;
	@Autowired
	private PersonRepository personDao;
	@Autowired 
	private StreetRepository streetDao;
	
	@Transactional
	public List<PersonResponse> buildResponse(List<PersonRequest> request) {
		List<PersonResponse> response = new LinkedList<>();
		if(request!=null) {
			for(PersonRequest req: request) {
				if(req.getPassportNumber()!=null&&req.getPassportDate()!=null&&req.getPassportSeria()!=null) {
					log.info("Check not child");
					Optional<Passport> passOptional = passportDao.findByPassportDateAndNumberAndSeria(req.getPassportDate(), req.getPassportNumber(), req.getPassportSeria());
					if(passOptional.isPresent()) {
						log.info("passOptional {}", passOptional.get());
						Optional<Person> personOptional = SearhPerson(req, passOptional.get().getPerson().getPersonId());
						if(personOptional.isPresent()) {
							log.info("personOptional {}", personOptional.get());
							Optional<Street> streetOptional = searchStreet(req);
							if(streetOptional.isPresent()) {
								
								Optional<Long> listAddressStreet = addressDao.findAddress(personOptional.get().getPersonId(), streetOptional.get().getStreetId());
								if(listAddressStreet.isPresent()) {
									
//									for(Long streetId: listAddressStreet.get()) {
////										if(streetOptional.get().getStreetId()==streetId) {
											infoPersonResponse(response, req);
////											break;
////										}
//									}
									continue;
								}
							}
						}
					}
				} else {
					Optional<Birth> birthOptional = birthDao.findByBirthNumberAndBirthCertificateDate(req.getBirthCertififcate(), req.getBirthCertificateDate());
					if(birthOptional.isPresent()) {
						Optional<Person> personOptional = SearhPerson(req, birthOptional.get().getPerson().getPersonId());
						if(personOptional.isPresent()) {
							Optional<Street> streetOptional = searchStreet(req);
							if(streetOptional.isPresent()) {
								Optional<Long> listAddressStreet = addressDao.findAddress(personOptional.get().getPersonId(), streetOptional.get().getStreetId());
								
								if(listAddressStreet.isPresent()) {
								
								
								infoPersonResponse(response, req);
								continue;
								}
							}
						}
					}
					
					
					
					
				}
				PersonResponse resp = new PersonResponse();
				resp.setFirstName(req.getGivenName());
				resp.setPatronymic(req.getPatronymic());
				resp.setRegistered(false);
				response.add(resp);
			} 
		}
		
		return response;
	}

	private void infoPersonResponse(List<PersonResponse> response, PersonRequest req) {
		PersonResponse resp = new PersonResponse();
		resp.setFirstName(req.getGivenName());
		resp.setPatronymic(req.getPatronymic());
		resp.setRegistered(true);
		response.add(resp);
	}

	private Optional<Street> searchStreet(PersonRequest req) {
		Optional<Street> streetOptional = streetDao.findByStreetNameAndBuildingAndExtensionAndAppartment(req.getStreetName(), req.getBuilding(), req.getExtension(), req.getApartment());
		return streetOptional;
	}

	private Optional<Person> SearhPerson(PersonRequest req, Long personId) {
		Optional<Person> personOptional = personDao.findByPersonIdAndSurNameAndGivenNameAndPatronymicAndDateOfBirth(personId, req.getSurName(), req.getGivenName(), req.getPatronymic(), req.getDateOfBirth());
		return personOptional;
	}

	
	
	
}

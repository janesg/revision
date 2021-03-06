package dev.codebase.gcj.gallery.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dev.codebase.gcj.gallery.dao.*;
import dev.codebase.gcj.gallery.domain.*;
import dev.codebase.gcj.gallery.exception.*;

@Service(value = "artworkFacade")
@Transactional
public class ArtworkFacadeImpl implements ArtworkFacade {

    private PersonDao personDao;
    private ArtDataDao artDataDao;
    private CategoryDao categoryDao;
    private ArtEntityDao artEntityDao;
    private ExhibitionDao exhibitionDao;

    // *************Artwork DAO Methods *************/    
    @Transactional(readOnly = true)
    @Override
    public ArtEntity getArtEntity(Long id) throws DataAccessException {
        return artEntityDao.get(id);
    }

    @Transactional(readOnly = true)
    @Override
    public ArtEntity getArtEntityByTitle(String title) throws DataAccessException {
        return artEntityDao.getArtEntityByTitle(title);
    }

    @Transactional(readOnly = true)
    @Override
    public ArtData getArtData(Long id) throws DataAccessException {
        return artDataDao.get(id);
    }

    @Transactional(readOnly = true)
    @Override
    public ArtData getArtDataFromEntity(ArtEntity entity, String imageFormat) throws DataAccessException {
        return artDataDao.getArtDataFromEntity(entity, imageFormat);
    }

    @Transactional(rollbackFor=DataAccessException.class, 
                   readOnly=false, 
                   timeout=30, 
                   propagation=Propagation.SUPPORTS, 
                   isolation=Isolation.DEFAULT)
    @Override
    public void saveArtEntity(ArtEntity art) throws DataAccessException {
        artEntityDao.save(art);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ArtEntity> getArtInExhibition(Long exhibitionId) throws DataAccessException {
        return artEntityDao.getArtInExhibition(exhibitionId);
    }

    // *************Category DAO Methods *************/

    @Transactional(readOnly = true)
    @Override
    public List<Category> getCategories() throws DataAccessException {
        return categoryDao.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Category getCategory(Long catId) throws DataAccessException {
        return categoryDao.get(catId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ArtEntity> getArtworkInCategory(Long catId) throws DataAccessException {
        return artEntityDao.getArtworkInCategory(catId);
    }

    @Transactional(readOnly = false)
    @Override
    public void saveCategory(Category category) throws DataAccessException {
        categoryDao.save(category);
    }

    // *************Exhibition DAO Methods *************/
    @Transactional(readOnly = true)
    @Override
    public List<Exhibition> getExhibitions() throws DataAccessException {
        return exhibitionDao.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Exhibition getExhibition(Long exhibitionId) throws DataAccessException {
        return exhibitionDao.get(exhibitionId);
    }

    @Transactional(readOnly = false)
    @Override
    public void saveExhibition(Exhibition exhibition) throws DataAccessException {
        exhibitionDao.save(exhibition);
    }

    // *************Person DAO Methods *************/
    @Transactional(readOnly = true)
    @Override
    public Person getPerson(Long personId) throws DataAccessException {
        return personDao.get(personId);
    }

    @Transactional(readOnly = false)
    @Override
    public void savePerson(Person person) throws DataAccessException {
        personDao.save(person);
    }

    @Transactional(readOnly = true)
    @Override
    public Person authenticatePerson(String username, String password) throws DataAccessException, AuthenticationException {
        return personDao.authenticatePerson(username, password);
    }

    @Transactional(readOnly = true)
    @Override
    public Person getPersonByUsername(String username) throws DataAccessException, EntityNotFoundException {
        return personDao.getPersonByUsername(username);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> getPeople() throws DataAccessException {
        return personDao.getAll();
    }

    public ArtEntityDao getArtEntityDao() {
        return artEntityDao;
    }

    @Autowired
    public void setArtEntityDao(ArtEntityDao artEntityDao) {
        this.artEntityDao = artEntityDao;
    }

    public ArtDataDao getArtDataDao() {
        return artDataDao;
    }

    @Autowired
    public void setArtDataDao(ArtDataDao artDataDao) {
        this.artDataDao = artDataDao;
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public ExhibitionDao getExhibitionDao() {
        return exhibitionDao;
    }

    @Autowired
    public void setExhibitionDao(ExhibitionDao exhibitionDao) {
        this.exhibitionDao = exhibitionDao;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

}

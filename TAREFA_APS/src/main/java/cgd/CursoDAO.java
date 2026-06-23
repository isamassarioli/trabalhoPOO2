package cgd;

import cdp.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CursoDAO {
    public CursoDAO() {
    }

    public int save(Curso curso) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Erro ao salvar curso: " + e.getMessage());
            return -1;
        } finally {
            em.close();
        }
    }

    public Curso get(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Curso> query = em.createQuery(
                "SELECT DISTINCT c FROM Curso c LEFT JOIN FETCH c.turmas WHERE c.id = :id",
                Curso.class
            );
            query.setParameter("id", id);
            List<Curso> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } finally {
            em.close();
        }
    }

    public List<Curso> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Curso> query = em.createQuery(
                "SELECT DISTINCT c FROM Curso c LEFT JOIN FETCH c.turmas",
                Curso.class
            );
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Curso> findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Curso> query = em.createQuery(
                "SELECT DISTINCT c FROM Curso c LEFT JOIN FETCH c.turmas WHERE c.id = :id",
                Curso.class
            );
            query.setParameter("id", id);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Curso> findByNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Curso> query = em.createQuery(
                "SELECT DISTINCT c FROM Curso c LEFT JOIN FETCH c.turmas WHERE LOWER(c.nome) LIKE LOWER(:nome)",
                Curso.class
            );
            query.setParameter("nome", "%" + nome + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Curso> findByCargaHoraria(int cargaHoraria) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Curso> query = em.createQuery(
                "SELECT DISTINCT c FROM Curso c LEFT JOIN FETCH c.turmas WHERE c.cargaHoraria = :cargaHoraria",
                Curso.class
            );
            query.setParameter("cargaHoraria", cargaHoraria);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public int update(Curso curso) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Erro ao atualizar curso: " + e.getMessage());
            return -1;
        } finally {
            em.close();
        }
    }

    public int delete(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Curso curso = em.find(Curso.class, id);
            if (curso == null) return 0;
            em.getTransaction().begin();
            em.remove(curso);
            em.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Erro ao deletar curso: " + e.getMessage());
            return -1;
        } finally {
            em.close();
        }
    }
}


















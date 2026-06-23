package cgd;

import cdp.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class AlunoDAO {
    public AlunoDAO() {
    }

    public int save(Aluno aluno) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Erro ao salvar aluno: " + e.getMessage());
            return -1;
        } finally {
            em.close();
        }
    }

    public Aluno get(long cpf) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Aluno> query = em.createQuery(
                "SELECT DISTINCT a FROM Aluno a LEFT JOIN FETCH a.turmas WHERE a.CPF = :cpf",
                Aluno.class
            );
            query.setParameter("cpf", cpf);
            List<Aluno> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } finally {
            em.close();
        }
    }

    public List<Aluno> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Aluno> query = em.createQuery(
                "SELECT DISTINCT a FROM Aluno a LEFT JOIN FETCH a.turmas",
                Aluno.class
            );
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Aluno> findByNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Aluno> query = em.createQuery(
                "SELECT DISTINCT a FROM Aluno a LEFT JOIN FETCH a.turmas WHERE LOWER(a.nome) LIKE LOWER(:nome)",
                Aluno.class
            );
            query.setParameter("nome", "%" + nome + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Aluno> findByCpf(long cpf) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Aluno> query = em.createQuery(
                "SELECT DISTINCT a FROM Aluno a LEFT JOIN FETCH a.turmas WHERE a.CPF = :cpf",
                Aluno.class
            );
            query.setParameter("cpf", cpf);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Aluno> findByDataNascimento(Date dataNascimento) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Aluno> query = em.createQuery(
                "SELECT DISTINCT a FROM Aluno a LEFT JOIN FETCH a.turmas WHERE a.dataNascimento = :dataNascimento",
                Aluno.class
            );
            query.setParameter("dataNascimento", dataNascimento);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public int update(Aluno aluno) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Erro ao atualizar aluno: " + e.getMessage());
            return -1;
        } finally {
            em.close();
        }
    }

    public int delete(long cpf) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Aluno aluno = em.find(Aluno.class, cpf);
            if (aluno == null) return 0;
            em.getTransaction().begin();
            em.remove(aluno);
            em.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.out.println("Erro ao deletar aluno: " + e.getMessage());
            return -1;
        } finally {
            em.close();
        }
    }
}

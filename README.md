# 🎓 Gestion de Projets Étudiants

## 📚 Sommaire
- [📌 Contexte](#-contexte)
- [❓ Problématique](#-problématique)
- [🎯 Objectifs](#-objectifs)
- [🧩 Diagramme de Classe](#-diagramme-de-classe)
- [🛠 Technologies](#-technologies)

---

## 📌 Contexte

Ce projet est une application web développée en Java pour la gestion des projets académiques. Il permet :
- Aux **enseignants** d'encadrer des projets et d'affecter des étudiants
- Aux **étudiants** de consulter leurs projets attribués
- À l'**administration** de suivre les statistiques par encadrant

---

## ❓ Problématique

La gestion manuelle des projets étudiants présente plusieurs défis :
- Difficulté à suivre les affectations projet/étudiant
- Manque de visibilité sur la charge des encadrants
- Processus d'attribution chronophage
- Absence de statistiques centralisées

---

## 🎯 Objectifs

- Créer une plateforme centralisée pour :
  - 📋 Lister tous les projets disponibles
  - 👥 Affecter dynamiquement des étudiants (via AJAX)
  - 📊 Générer des statistiques par encadrant (Chart.js)
- Fournir aux étudiants :
  - 👀 Visualisation de leurs projets
  - 🔔 Notifications des deadlines

---

## 🧩 Diagramme de Classe
 ![image](https://github.com/user-attachments/assets/f2433b90-adcf-49da-ae1f-f0235a4cbb6c)

---

## 🛠 Technologies

### 🖥️ Côté client (Frontend) :
- **HTML5 / CSS3** – Pour la structure et le style des pages.
- **JavaScript** – Pour les interactions dynamiques et la logique côté client.
- **AJAX** – Permet des échanges asynchrones avec le serveur sans recharger la page (affectation en temps réel).
- **Chart.js** – Génération de graphiques interactifs pour les statistiques liées aux encadrants et projets.

### ⚙️ Côté serveur (Backend) :
- **Java Web** – Technologie principale pour la logique métier.
- **Hibernate** – Pour la gestion de la persistance des données de manière orientée objet.
- **JDBC** – Utilisé ponctuellement pour des requêtes spécifiques non prises en charge par l’ORM.

### 🗃️ Base de données :
- **MySQL** – Système relationnel pour la gestion des données (étudiants, enseignants, projets, affectations).


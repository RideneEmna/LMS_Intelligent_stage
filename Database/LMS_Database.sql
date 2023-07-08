PGDMP     /    0                {            LMS    15.3    15.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16398    LMS    DATABASE     x   CREATE DATABASE "LMS" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'French_France.1252';
    DROP DATABASE "LMS";
                postgres    false            �            1259    16402    Administrateur    TABLE     �   CREATE TABLE public."Administrateur" (
    "idAdmin" integer NOT NULL,
    login character varying(100),
    mdp character varying(100),
    email character varying(100),
    telephone character varying(100)
);
 $   DROP TABLE public."Administrateur";
       public         heap    postgres    false            �            1259    16414    Cours    TABLE     �   CREATE TABLE public."Cours" (
    "idCours" integer NOT NULL,
    titre character varying(200),
    "idEnseignant" integer,
    matiere character varying(100),
    description text,
    "dateAjout" date,
    "nbHeures" integer
);
    DROP TABLE public."Cours";
       public         heap    postgres    false            �            1259    16427 
   Enseignant    TABLE     >  CREATE TABLE public."Enseignant" (
    "idEnseignant" integer NOT NULL,
    nom character varying(100),
    prenom character varying(100),
    login character varying(100),
    mdp character varying(100),
    email character varying(100),
    telephone character varying(100),
    specialite character varying(100)
);
     DROP TABLE public."Enseignant";
       public         heap    postgres    false            �            1259    16407    Etudiant    TABLE     M  CREATE TABLE public."Etudiant" (
    "idEtudiant" integer NOT NULL,
    nom character varying(100),
    prenom character varying(100),
    login character varying(100),
    mdp character varying(100),
    email character varying(100),
    telephone character varying(100),
    niveau character varying(100),
    "idCours" integer
);
    DROP TABLE public."Etudiant";
       public         heap    postgres    false            
          0    16402    Administrateur 
   TABLE DATA           S   COPY public."Administrateur" ("idAdmin", login, mdp, email, telephone) FROM stdin;
    public          postgres    false    214   $                 0    16414    Cours 
   TABLE DATA           r   COPY public."Cours" ("idCours", titre, "idEnseignant", matiere, description, "dateAjout", "nbHeures") FROM stdin;
    public          postgres    false    216   A                 0    16427 
   Enseignant 
   TABLE DATA           m   COPY public."Enseignant" ("idEnseignant", nom, prenom, login, mdp, email, telephone, specialite) FROM stdin;
    public          postgres    false    217   ^                 0    16407    Etudiant 
   TABLE DATA           p   COPY public."Etudiant" ("idEtudiant", nom, prenom, login, mdp, email, telephone, niveau, "idCours") FROM stdin;
    public          postgres    false    215   {       q           2606    16406 "   Administrateur Administrateur_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public."Administrateur"
    ADD CONSTRAINT "Administrateur_pkey" PRIMARY KEY ("idAdmin");
 P   ALTER TABLE ONLY public."Administrateur" DROP CONSTRAINT "Administrateur_pkey";
       public            postgres    false    214            v           2606    16420    Cours Cours_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public."Cours"
    ADD CONSTRAINT "Cours_pkey" PRIMARY KEY ("idCours");
 >   ALTER TABLE ONLY public."Cours" DROP CONSTRAINT "Cours_pkey";
       public            postgres    false    216            y           2606    16433    Enseignant Enseignant_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public."Enseignant"
    ADD CONSTRAINT "Enseignant_pkey" PRIMARY KEY ("idEnseignant");
 H   ALTER TABLE ONLY public."Enseignant" DROP CONSTRAINT "Enseignant_pkey";
       public            postgres    false    217            s           2606    16413    Etudiant Etudiant_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public."Etudiant"
    ADD CONSTRAINT "Etudiant_pkey" PRIMARY KEY ("idEtudiant");
 D   ALTER TABLE ONLY public."Etudiant" DROP CONSTRAINT "Etudiant_pkey";
       public            postgres    false    215            t           1259    16426    fki_Cours_fkey    INDEX     L   CREATE INDEX "fki_Cours_fkey" ON public."Etudiant" USING btree ("idCours");
 $   DROP INDEX public."fki_Cours_fkey";
       public            postgres    false    215            w           1259    16439    fki_Enseignant_fkey    INDEX     S   CREATE INDEX "fki_Enseignant_fkey" ON public."Cours" USING btree ("idEnseignant");
 )   DROP INDEX public."fki_Enseignant_fkey";
       public            postgres    false    216            z           2606    16421    Etudiant Cours_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Etudiant"
    ADD CONSTRAINT "Cours_fkey" FOREIGN KEY ("idCours") REFERENCES public."Cours"("idCours") NOT VALID;
 A   ALTER TABLE ONLY public."Etudiant" DROP CONSTRAINT "Cours_fkey";
       public          postgres    false    216    3190    215            {           2606    16434    Cours Enseignant_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public."Cours"
    ADD CONSTRAINT "Enseignant_fkey" FOREIGN KEY ("idEnseignant") REFERENCES public."Enseignant"("idEnseignant") NOT VALID;
 C   ALTER TABLE ONLY public."Cours" DROP CONSTRAINT "Enseignant_fkey";
       public          postgres    false    216    217    3193            
      x������ � �            x������ � �            x������ � �            x������ � �     
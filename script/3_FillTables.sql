INSERT INTO public.questionary
	(id, name, start, ends, briefing, slug, active)
VALUES 
	(1, 'Qual o celular?', '2017-05-23', '2017-05-31', 'Qual o celular?', 'qual-celular', true);

INSERT INTO public.question
	(id, question, questionary)
	VALUES (1, 'Como seria o celular ideal para você?', 1);

INSERT INTO public.typeprofile
	(id, name, active, description, level)
VALUES
	(1, 'Admin', true, 'admin', 1),
	(2, 'Crowd', true, 'crowd', 2);

INSERT INTO public.profile
	(id, name, mail, typeprofile, city, state, sex, studies, position)
VALUES
	(1, 'ricardo', 'ricardo', 1, 'Assis', 'SP', 'M', 'Superior', 'Analista');
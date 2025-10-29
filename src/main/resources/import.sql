-- 0) Habilitar pgcrypto (para gen_random_uuid y crypt)
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- 1) Sembrar roles (idempotente)
INSERT INTO rol (nombre, permisos)
VALUES
 ('admin',    NULL),
 ('comision', NULL),
 ('docente',  NULL),
 ('alumno',   NULL)
ON CONFLICT (nombre) DO NOTHING;

-- 2) Usuarios con contraseñas BCRYPT (idempotente)
-- Admin
WITH r AS (SELECT id_rol FROM rol WHERE nombre = 'admin')
INSERT INTO usuario (nombre, correo, rol_id, password_hash, estado, creado_en)
SELECT 'Administrador', 'admin@sed.com', r.id_rol,
       crypt('123456', gen_salt('bf', 10)),  -- CAMBIA la clave luego
       'ACTIVO', now()
FROM r
ON CONFLICT (correo) DO NOTHING;

-- Comisión
WITH r AS (SELECT id_rol FROM rol WHERE nombre = 'comision')
INSERT INTO usuario (nombre, correo, rol_id, password_hash, estado, creado_en)
SELECT 'Comisión', 'comision@sed.com', r.id_rol,
       crypt('123456', gen_salt('bf', 10)),
       'ACTIVO', now()
FROM r
ON CONFLICT (correo) DO NOTHING;

-- Docente
WITH r AS (SELECT id_rol FROM rol WHERE nombre = 'docente')
INSERT INTO usuario (nombre, correo, rol_id, password_hash, estado, creado_en)
SELECT 'Docente', 'docente@sed.com', r.id_rol,
       crypt('123456', gen_salt('bf', 10)),
       'ACTIVO', now()
FROM r
ON CONFLICT (correo) DO NOTHING;

-- Alumno
WITH r AS (SELECT id_rol FROM rol WHERE nombre = 'alumno')
INSERT INTO usuario (nombre, correo, rol_id, password_hash, estado, creado_en)
SELECT 'Alumno', 'alumno@sed.com', r.id_rol,
       crypt('123456', gen_salt('bf', 10)),
       'ACTIVO', now()
FROM r
ON CONFLICT (correo) DO NOTHING;

-- 3) Verificación rápida
SELECT u.correo, u.estado, r.nombre AS rol, (u.password_hash LIKE '$2%') AS es_bcrypt
FROM usuario u
JOIN rol r ON r.id_rol = u.rol_id
ORDER BY u.correo;

-- OPCIONAL: si hoy tienes contraseñas en claro y quieres re-hashear solo las no-BCrypt:
-- (Ejecuta esto UNA vez y solo si estás seguro que password_hash contiene texto plano)
-- UPDATE usuario
--    SET password_hash = crypt(password_hash, gen_salt('bf', 10))
--  WHERE password_hash IS NOT NULL
--    AND password_hash NOT LIKE '$2%';

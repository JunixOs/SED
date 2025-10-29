-- 0) Habilitar pgcrypto (para gen_random_uuid y crypt)
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- 1) Limpiar e insertar roles
-- Usamos DELETE primero para evitar duplicados
DELETE FROM usuario WHERE correo IN (
    'admin@sed.com',
    'comision@sed.com',
    'docente@sed.com',
    'alumno@sed.com'
);

DELETE FROM rol WHERE nombre IN ('admin', 'comision', 'docente', 'alumno');

-- Insertar roles de manera segura
INSERT INTO rol (nombre, permisos)
VALUES 
('admin', NULL),
('comision', NULL),
('docente', NULL),
('alumno', NULL)
ON CONFLICT (nombre) DO NOTHING;

-- 2) Limpiar e insertar usuarios

-- Inserción de usuarios usando SELECT de roles
INSERT INTO usuario (nombre, correo, rol_id, password_hash, estado, creado_en)
SELECT 'Administrador', 'admin@sed.com', id_rol, crypt('123456', gen_salt('bf', 10)), 'ACTIVO', now()
FROM rol WHERE nombre = 'admin'
ON CONFLICT (correo) DO NOTHING;

INSERT INTO usuario (nombre, correo, rol_id, password_hash, estado, creado_en)
SELECT 'Comisión', 'comision@sed.com', id_rol, crypt('123456', gen_salt('bf', 10)), 'ACTIVO', now()
FROM rol WHERE nombre = 'comision'
ON CONFLICT (correo) DO NOTHING;

INSERT INTO usuario (nombre, correo, rol_id, password_hash, estado, creado_en)
SELECT 'Docente', 'docente@sed.com', id_rol, crypt('123456', gen_salt('bf', 10)), 'ACTIVO', now()
FROM rol WHERE nombre = 'docente'
ON CONFLICT (correo) DO NOTHING;

INSERT INTO usuario (nombre, correo, rol_id, password_hash, estado, creado_en)
SELECT 'Alumno', 'alumno@sed.com', id_rol, crypt('123456', gen_salt('bf', 10)), 'ACTIVO', now()
FROM rol WHERE nombre = 'alumno'
ON CONFLICT (correo) DO NOTHING;
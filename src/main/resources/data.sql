-- 0) Habilitar pgcrypto (para gen_random_uuid y crypt)
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- 1) Limpiar e insertar roles

-- Limpiar relaciones
DELETE FROM usuario_rol 
WHERE usuario_id IN (
    SELECT id_usuario FROM usuario 
    WHERE correo IN (
        'admin@sed.com',
        'comision@sed.com',
        'docente@sed.com',
        'alumno@sed.com'
    )
);

-- Limpiar Usuarios
DELETE FROM usuario WHERE correo IN (
    'admin@sed.com',
    'comision@sed.com',
    'docente@sed.com',
    'alumno@sed.com'
);

DELETE FROM rol WHERE nombre IN ('admin', 'comision', 'docente', 'alumno');

-- Insertar roles de manera segura
INSERT INTO rol (nombre)
VALUES 
('admin'),
('comision'),
('docente'),
('alumno')
ON CONFLICT (nombre) DO NOTHING;

-- 2) Limpiar e insertar estados de usuario

DELETE FROM usuario WHERE correo IN (
    'admin@sed.com',
    'comision@sed.com',
    'docente@sed.com',
    'alumno@sed.com'
);

DELETE FROM estado_usuario WHERE codigo IN (
    'ACTIVE',
    'DELETED',
    'INACTIVE',
    'SUSPENDED'
);

INSERT INTO estado_usuario (codigo, etiqueta)
VALUES 
('ACTIVE', 'Activo'),
('DELETED', 'Eliminado'),
('INACTIVE', 'Inactivo'),
('SUSPENDED', 'Suspendido')
ON CONFLICT (codigo) DO NOTHING;


-- 3) Insertar usuarios correctamente (usando FK real)

INSERT INTO usuario (nombre_completo, correo, estado_usuario_id, password_hash, creado_en, actualizado_en)
SELECT 
    'Administrador',
    'admin@sed.com',
    e.id_estado_usuario,
    crypt('123456', gen_salt('bf', 10)),
    now(),
    now()
FROM estado_usuario e
WHERE e.codigo = 'ACTIVE';

INSERT INTO usuario (nombre_completo, correo, estado_usuario_id, password_hash, creado_en, actualizado_en)
SELECT 
    'Comisión',
    'comision@sed.com',
    e.id_estado_usuario,
    crypt('123456', gen_salt('bf', 10)),
    now(),
    now()
FROM estado_usuario e
WHERE e.codigo = 'ACTIVE';

INSERT INTO usuario (nombre_completo, correo, estado_usuario_id, password_hash, creado_en, actualizado_en)
SELECT 
    'Docente',
    'docente@sed.com',
    e.id_estado_usuario,
    crypt('123456', gen_salt('bf', 10)),
    now(),
    now()
FROM estado_usuario e
WHERE e.codigo = 'ACTIVE';

INSERT INTO usuario (nombre_completo, correo, estado_usuario_id, password_hash, creado_en, actualizado_en)
SELECT 
    'Alumno',
    'alumno@sed.com',
    e.id_estado_usuario,
    crypt('123456', gen_salt('bf', 10)),
    now(),
    now()
FROM estado_usuario e
WHERE e.codigo = 'ACTIVE';


-- Insertar relaciones
INSERT INTO usuario_rol (usuario_id, rol_id)
SELECT u.id_usuario, r.id_rol
FROM usuario u
JOIN rol r ON r.nombre = 'admin'
WHERE u.correo = 'admin@sed.com';

INSERT INTO usuario_rol (usuario_id, rol_id)
SELECT u.id_usuario, r.id_rol
FROM usuario u
JOIN rol r ON r.nombre = 'comision'
WHERE u.correo = 'comision@sed.com';

INSERT INTO usuario_rol (usuario_id, rol_id)
SELECT u.id_usuario, r.id_rol
FROM usuario u
JOIN rol r ON r.nombre = 'docente'
WHERE u.correo = 'docente@sed.com';

INSERT INTO usuario_rol (usuario_id, rol_id)
SELECT u.id_usuario, r.id_rol
FROM usuario u
JOIN rol r ON r.nombre = 'alumno'
WHERE u.correo = 'alumno@sed.com';
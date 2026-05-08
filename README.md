# WannaSmyle

**Autores:** Stefan Trifan y Alfredo Muñoz

**Descripción**

WannaSmile es una aplicación desarrollada en Java que simula el funcionamiento de un sistema de ciberseguridad capaz de detectar y responder ante diferentes tipos malware.

---

**Objetivo**

- Aplicar principios de programación orientada a objetos y patrones de diseño.
- Simular distintos escenarios de ciberseguridad mediante sistemas y malware configurables.

---

**Restricciones**

- Sin interfaz gráfica
- Sin librerías externas

---

**Alcance**

- Modo de juego: Simulación
- Lenguaje: Java
- Features:
    - Información del sistema en tiempo real desde la terminal

---

## Reglas del simulador

### **Flujo Básico**

1. Inicio programa
2. Usuario elige sistema → Se genera el sistema
3. El usuario elige o crea amenaza → se genera malware
4. El sistema recibe la amenaza.
5. El sistema activa verificación
    1. Analizar
        1. Análisis Manual
        2. Anlálisis Automático. Elegir estrategia:
            - Análisis Rápido
            - Análisis Profundo
            - Análisis Heurístico
    2. Responder
    3. Mostrar resultado

---

### **Componentes**

- Jugador 1:
    - Configura el malware
- Jugador 2:
    - Configura sistema
    - Configura antivirus
- Sistema:
    - Coordina la defensa.
    - Tiene: detección y contención
- Malware:
    - Asociado a sistema
    - Tiene: sigilo y propagación.
- Antivirus:
    - Gestiona la defensa en 3 fases: analizar, responder y mostrar resultado.

---

### Modelo de juego

Creación de sistema:

- La suma de detección y contención es constante (100) → equilibrio entre identificar amenazas y neutralizarlas.

Creación de malware:

- La suma de sigilo y propagación es constante (100), lo que representa un equilibrio entre ocultación y capacidad de expansión.
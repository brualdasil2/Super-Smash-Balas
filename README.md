# Super-Smash-Balas
Jogo original Super Smash Balas desenvolvido em Java de 21/05/20 até 09/12/20.

Esse jogo de luta em 2D tem os golpes inspirados em Super Smash Bros, e o layout de luta inspitado em Street Fighter.

Site com mais informações: supersmashbalas.com

Menu inicial:
![image](https://user-images.githubusercontent.com/73000207/127052599-f15e37bd-ae7c-4d95-b8ac-104d82981df1.png)

# Como executar o jogo
- Instalar Java JRE de alguma das versões mais recentes
- Executar o arquivo SuperSmashBalas.jar

# Renderização da tela
  - Para otimizar o processo de atualizar a tela a 60 fps, ela foi dividida em uma grade, na qual só são atualizados os quadrados nos quais algo se moveu ou mudou. Cada objeto que se move ou altera seu estado visual chama uma função que "marca" quais quadrados devem ser atualizados naquele frame. Desse modo, só se gasta processamento atualizando as partes da tela que são necessárias.

# Personagens
- Bruno: O personagem mais básico, tem golpes de médio alcance, um projétil, e bom potencial para combos.
- Carol: Zoner do jogo, utiliza seus projéteis, golpes de longo alcance e excelente movimentação aérea para acertar os oponentes à distância.
- Lacerda: O personagem mais rápido do jogo, com os golpes mais rápidos e ótimos combos.
- Obino: Tank do jogo, é o mais lento, mas com os golpes mais poderosos, consegue vencer uma partida com poucos golpes bem usados.

# Modos de jogo
- **P vs P:** Luta 1v1 contra um amigo, cada um usando uma parte do teclado.
  - Escolha de personagens:
  ![image](https://user-images.githubusercontent.com/73000207/127052757-a172d2dc-8926-4fca-8102-eaaea1d9a395.png)
  - Luta:
  ![image](https://user-images.githubusercontent.com/73000207/127052979-802b2c00-647d-4051-9b23-6f846408794b.png)
  
- **P vs Bot:** Luta contra um bot que pode ter 3 dificuldades: "Fácil", "Médio", e "Difícil".

- **Minigames:**
  - Sobrevivência: Luta contra uma sequência de Bots, um de cada vez, até perder.
     ![image](https://user-images.githubusercontent.com/73000207/127053355-ad7e092d-9c4f-478a-ad75-8a122e87a410.png)


  - Alvos: Quebrar o máximo possível de alvos que aparecem aleatoriamente na tela em 60 segundos.
      ![image](https://user-images.githubusercontent.com/73000207/127053229-db35a5da-55d1-405a-8700-4c0a4c3deaf9.png)

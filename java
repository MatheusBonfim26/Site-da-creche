// Mostrar mensagem ao clicar em uma matéria
document.querySelectorAll('.materia').forEach(materia => {
    materia.addEventListener('click', () => {
      alert(`Você clicou em: ${materia.querySelector('h2').textContent}! Vamos aprender! 🎉`);
      materia.classList.add('clicado');
  
      setTimeout(() => {
        materia.classList.remove('clicado');
      }, 500);
    });
  });
  
  // Trocar fundo do céu ao clicar em um botão
  function trocarCeu() {
    const body = document.body;
    if (body.classList.contains('ceu-tarde')) {
      body.classList.remove('ceu-tarde');
      body.classList.add('ceu-noite');
    } else if (body.classList.contains('ceu-noite')) {
      body.classList.remove('ceu-noite');
    } else {
      body.classList.add('ceu-tarde');
    }
  }
  
  // Botão para trocar o céu
  const botaoCeu = document.createElement('button');
  botaoCeu.textContent = "Trocar o céu 🌤️";
  botaoCeu.className = "botao-ceu";
  botaoCeu.onclick = trocarCeu;
  document.body.appendChild(botaoCeu);
  
  // Torna os blocos arrastáveis com o mouse
  let arrastando = null;
  
  document.querySelectorAll('.materia').forEach(materia => {
    materia.style.position = 'relative';
    materia.addEventListener('mousedown', e => {
      arrastando = materia;
      materia.dataset.offsetX = e.offsetX;
      materia.dataset.offsetY = e.offsetY;
    });
  });
  
  document.addEventListener('mousemove', e => {
    if (arrastando) {
      arrastando.style.left = (e.pageX - arrastando.dataset.offsetX) + 'px';
      arrastando.style.top = (e.pageY - arrastando.dataset.offsetY) + 'px';
      arrastando.style.zIndex = 1000;
    }
  });
  
  document.addEventListener('mouseup', () => {
    if (arrastando) arrastando = null;
  });
  

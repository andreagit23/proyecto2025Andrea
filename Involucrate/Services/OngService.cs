using Involucrate.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Involucrate.Services
{
    class OngService
    {
        private readonly HttpClient _httpClient;

        public OngService()
        {
            _httpClient = new HttpClient();
        }

        internal Task UpdateOngAsync(ONG currentOng)
        {
            throw new NotImplementedException();
        }

        /*  public async Task<List<ONG>> GetOngsAsync()
          {
              // Implementar llamada a la API para obtener todas las ONGs
          }

          public async Task<List<ONG>> GetUserOngsAsync(string userId)
          {
              // Implementar llamada a la API para obtener ONGs del usuario
          }

          public async Task<bool> CreateOngAsync(ONG newOng)
          {
              // Implementar llamada a la API para crear una nueva ONG
          }

          public async Task<bool> UpdateOngAsync(ONG updatedOng)
          {
              // Implementar llamada a la API para actualizar una ONG existente
          }*/
    }
}
